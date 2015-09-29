package application.config;

import javax.sql.DataSource;

/**
 * 
 * @author Vu, Nguyen
 * @since Sept 16, 2015
 * @Description Contain information of System
 */
public class ServerConfiguration {
	private int timeout;
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	private ServerConfiguration() {
		timeout = 30;
	}
	
	private static ServerConfiguration serverConfiguration;
	
	public static ServerConfiguration instance(){
		if(serverConfiguration == null)
			serverConfiguration= new ServerConfiguration();
		return serverConfiguration;
	}

}
