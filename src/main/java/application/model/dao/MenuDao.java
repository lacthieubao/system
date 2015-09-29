package application.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import application.config.ServerConfiguration;
import application.model.Menu;

/**
 * 
 * @author Vu, Nguyen
 *
 */

public class MenuDao {

	private JdbcTemplate jdbctemplate;

	private DataSource dataSource = ServerConfiguration.instance()
			.getDataSource();

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Menu> findByLevel(int level) {
		jdbctemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM menu WHERE level = ?";
		try {
			List<Menu> result = jdbctemplate.query(sql, new Object[] { level },
					new RowMapper<Menu>() {
						@Override
						public Menu mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							Menu menu = new Menu();
							menu.setId(rs.getLong("id"));
							menu.setName(rs.getString("name"));
							menu.setLevel(rs.getInt("level"));
							menu.setIdparent(rs.getLong("id"));
							return menu;
						}
					});
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<Menu> findAll() {
		jdbctemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM menu";
		try {
			List<Menu> result = jdbctemplate.query(sql, new RowMapper<Menu>() {
				@Override
				public Menu mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Menu menu = new Menu();
					menu.setId(rs.getLong("id"));
					menu.setName(rs.getString("name"));
					menu.setLevel(rs.getInt("level"));
					menu.setIdparent(rs.getLong("id"));
					return menu;
				}
			});
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<Menu> findByIdparent(long idparent) {
		jdbctemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM menu WHERE idparent = ?";
		try {
			List<Menu> result = jdbctemplate.query(sql,
					new Object[] { idparent }, new RowMapper<Menu>() {
						@Override
						public Menu mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							Menu menu = new Menu();
							menu.setId(rs.getLong("id"));
							menu.setName(rs.getString("name"));
							menu.setLevel(rs.getInt("level"));
							menu.setIdparent(rs.getLong("id"));
							return menu;
						}
					});
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
