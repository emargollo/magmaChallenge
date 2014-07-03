package magma.tools.benchmark.model;

import magma.monitor.command.IServerCommander;
import magma.monitor.general.impl.FactoryParameter;
import magma.monitor.general.impl.MonitorComponentFactory;
import magma.monitor.referee.IReferee;
import magma.monitor.referee.impl.SinglePlayerLauncher;
import magma.monitor.worldmodel.IMonitorWorldModel;

public class BenchmarkMonitorComponentFactory extends MonitorComponentFactory
{
	/**
	 * @param parameterObject TODO
	 */
	public BenchmarkMonitorComponentFactory(FactoryParameter parameterObject)
	{
		super(parameterObject);
	}

	/**
	 * Create a Referee
	 * 
	 * @param worldModel - the world model of the monitor
	 * @param serverCommander - the command interface to send server commands
	 * @param refereeID - 0 (default) for dummy referee, 1 for standard game
	 *        referee
	 * @return New Referee
	 */
	public IReferee createReferee(IMonitorWorldModel worldModel,
			IServerCommander serverCommander, int refereeID)
	{
		SinglePlayerLauncher launcher = new SinglePlayerLauncher(
				params.getServerIP(), params.getAgentPort(), params.getTeam1Name(),
				params.getTeam1Jar(), params.getTeam2Name());
		return new BenchmarkReferee(worldModel, serverCommander,
				params.getServerPid(), launcher, params.getPlayersPerTeam(),
				params.getDropHeight());
	}
}