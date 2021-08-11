package com.xworkz.jdbc.scam;

import static com.xworkz.jdbc.dto.constants.JdbcConstant.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.xworkz.jdbc.dto.ScamDTO;

public class OrderedByDesc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select count(s_name) as no_scams from scam_table";
			Statement statement = connection.createStatement();
			statement.execute(query);
			ResultSet result = statement.getResultSet();
			ScamDTO dto = null;
			Collection<ScamDTO> collect = new ArrayList<ScamDTO>();
			while (result.next()) {
				String name = result.getString("s_name");
				int id = result.getInt("s_id");
				String type = result.getString("s_type");
				Date year = result.getDate("s_year");
				String by = result.getString("s_by");
				String amount = result.getString("s_amount");
				String location = result.getString("s_location");
				String descript = result.getString("s_description");
				dto = new ScamDTO(id, name, type, year, by, amount, location, descript);
				System.out.println(dto);
				collect.add(dto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
