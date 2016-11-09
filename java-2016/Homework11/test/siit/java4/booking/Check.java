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

				Accomodation expected = new Accomodation(356, "room", "single",1,"good");
				String sqlQuery1 = "INSERT INTO accomodation " + "VALUES (356,'room','single',1,'good')";
				ps = conn.prepareStatement(sqlQuery1);
				ps.executeUpdate();
					

				String sqlQuery3 = "SELECT * FROM accomodation WHERE id = '356'";
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

				String sqlQuery2 = "DELETE FROM accomodation WHERE id = '356' ";
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

		@Test
		public void insertIntoRoom_Fair() throws SQLException {
			try {
				Class.forName("org.postgresql.Driver").newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection conn = connect("postgresql", "localhost", 5432, "Booking", "postgres", "VasileT.1991");
			if (conn == null)
				return;

			PreparedStatement ps = null;
			ResultSet rs = null;

			try {

				RoomFair expected = new RoomFair(356, 174, "june");
				String sqlQuery1 = "INSERT INTO room_fair " + "VALUES (356,174,'june')";
				ps = conn.prepareStatement(sqlQuery1);
				ps.executeUpdate();

				String sqlQuery3 = "SELECT * FROM room_fair WHERE id = '356'";
				ps = conn.prepareStatement(sqlQuery3);
				rs = ps.executeQuery();
				
				boolean hasResult = rs.next();
				if (hasResult) {
					do {
						RoomFair room_fair = new RoomFair(rs.getInt("id"), rs.getDouble("value"), rs.getString("season"));
						assertEquals(expected, room_fair);
					} while (rs.next());
				}
				rs.close();
				ps.close();

				String sqlQuery2 = "DELETE FROM room_fair WHERE id = '356' ";
				ps = conn.prepareStatement(sqlQuery2);
				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			finally {
				conn.close();
			}
		}

		@Test
		public void insertIntoAccomodation_Fair_Relation() throws SQLException {
			try {
				Class.forName("org.postgresql.Driver").newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection conn = connect("postgresql", "localhost", 5432, "Booking", "postgres", "VasileT.1991");
			if (conn == null)
				return;

			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				String sqlQuery6 = "INSERT INTO accomodation " + "VALUES (356,'room','single',1,'good')";
				ps = conn.prepareStatement(sqlQuery6);
				ps.executeUpdate();

				String sqlQuery7 = "INSERT INTO room_fair " + "VALUES (356,174,'june')";
				ps = conn.prepareStatement(sqlQuery7);
				ps.executeUpdate();

				AccomodationFairRelation expected = new AccomodationFairRelation(356, 356, 356);
				String sqlQuery1 = "INSERT INTO accomodation_fair_relation " + "VALUES (356,356,356)";
				ps = conn.prepareStatement(sqlQuery1);
				ps.executeUpdate();

				String sqlQuery3 = "SELECT * FROM accomodation_fair_relation WHERE id = '356'";
				ps = conn.prepareStatement(sqlQuery3);
				rs = ps.executeQuery();
				
				boolean hasResult = rs.next();
				if (hasResult) {
					do {
						AccomodationFairRelation accomodation_fair_relation = new AccomodationFairRelation(
								rs.getInt("id"), rs.getInt("id_accomodation"), rs.getInt("id_room_fair"));
						assertEquals(expected, accomodation_fair_relation);
					} while (rs.next());
				}

				String sqlQuery2 = "DELETE FROM accomodation_fair_relation WHERE id = '356' ";
				ps = conn.prepareStatement(sqlQuery2);
				ps.executeUpdate();

				String sqlQuery9 = "DELETE FROM room_fair WHERE id = '356' ";
				ps = conn.prepareStatement(sqlQuery9);
				ps.executeUpdate();

				String sqlQuery10 = "DELETE FROM accomodation WHERE id = '356' ";
				ps = conn.prepareStatement(sqlQuery10);
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

		@Test
		public void display() {

			try {
				Class.forName("org.postgresql.Driver").newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection conn = connect("postgresql", "localhost", 5432, "Booking", "postgres", "VasileT.1991");
			if (conn == null)
				return;

			PreparedStatement ps1 = null;

			try {
				String sqlQuery6 = "INSERT INTO accomodation " + "VALUES (356,'room','single',1,'good')";
				ps1 = conn.prepareStatement(sqlQuery6);
				ps1.executeUpdate();

				String sqlQuery7 = "INSERT INTO room_fair " + "VALUES (356,174,'june')";
				ps1 = conn.prepareStatement(sqlQuery7);
				ps1.executeUpdate();

				String sqlQuery1 = "INSERT INTO accomodation_fair_relation " + "VALUES (356,356,356)";
				ps1 = conn.prepareStatement(sqlQuery1);
				ps1.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			final String format = "%30s%30s\n";
			String sqlQuery = "SELECT accomodation_fair_relation.id_accomodation,room_fair.value FROM accomodation_fair_relation INNER JOIN room_fair ON accomodation_fair_relation.id_room_fair=room_fair.id ORDER BY accomodation_fair_relation.id_accomodation;";

			try (PreparedStatement ps = conn.prepareStatement(sqlQuery)) {
				try (ResultSet rs = ps.executeQuery()) {

					boolean hasResult = rs.next();
					if (hasResult) {
						System.out.format(format, "id_accomodation", "value");
						do {
							System.out.format(format, rs.getInt("id_accomodation"), rs.getString("value"));
						} while (rs.next());
					} else {
						System.out.println("No result");
					}
				} catch (SQLException e) {
					System.err.println("Cannot execute query: " + e.getMessage());
				}

			} catch (SQLException e) {
				System.err.println("Cannot execute query: " + e.getMessage());
			}

			try {
				String sqlQuery2 = "DELETE FROM accomodation_fair_relation WHERE id = '356' ";
				ps1 = conn.prepareStatement(sqlQuery2);
				ps1.executeUpdate();

				String sqlQuery9 = "DELETE FROM room_fair WHERE id = '356' ";
				ps1 = conn.prepareStatement(sqlQuery9);
				ps1.executeUpdate();

				String sqlQuery10 = "DELETE FROM accomodation WHERE id ='356'";
				ps1 = conn.prepareStatement(sqlQuery10);
				ps1.executeUpdate();

				ps1.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
		
	}

