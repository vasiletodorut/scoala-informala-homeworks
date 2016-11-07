package test.siit.java4.booking;


import static org.junit.Assert.assertEquals;
import org.junit.Test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

	public class Check {

		private static Connection connect(String type, String host, int port, String dbName, String user, String pw) {
			Connection conn = null;
			DriverManager.setLoginTimeout(60);
			String url = new StringBuilder().append("jdbc:").append(type).append("://").append(host).append(":")
					.append(port).append("/").append(dbName).append("?user=").append(user).append("&password=").append(pw)
					.toString();
			try {
				conn = DriverManager.getConnection(url);
			} catch (SQLException e) {
				System.err.println("Cannot connect to the database:" + e.getMessage());
			}
			return conn;
		}

		@Test
		public void insertIntoAccomodation() throws SQLException {
			try {
				Class.forName("org.postgresql.Driver").newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection conn = connect("postgresql", "localhost", 5432 , "Booking", "postgres", "VasileT.1991");
			if (conn == null)
				return;

			PreparedStatement ps = null;
			ResultSet rs = null;

			try {

				Accomodation expected = new Accomodation(1000, "room", "single",1,"good");
				String sqlQuery1 = "INSERT INTO accomodation " + "VALUES (1000,'room','single',1,'good')";
				ps = conn.prepareStatement(sqlQuery1);
				ps.executeUpdate();
					

				String sqlQuery3 = "SELECT * FROM accomodation WHERE id = '1000'";
				ps = conn.prepareStatement(sqlQuery3);
				rs = ps.executeQuery();
				
				boolean hasResult = rs.next();
				if (hasResult) {
					do {
						Accomodation accomodation = new Accomodation(rs.getInt("id"), rs.getString("type"),
								rs.getString("bed_type"), rs.getInt("max_guests"), rs.getString("description"));
						assertEquals(expected, accomodation);
					} while (rs.next());
				}

				String sqlQuery2 = "DELETE FROM accomodation WHERE id = '1000' ";
				ps = conn.prepareStatement(sqlQuery2);
				ps.executeUpdate();

				rs.close();
				ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			finally {
				conn.close();
			}
		}

	}

