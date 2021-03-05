package com.example.designPattern.proxy;

public class CommandAccessProxy implements CommandAccess {
	
	private boolean isAdmin;
	private CommandAccess access;
	
	public CommandAccessProxy(String user, String pwd) {
		if("Shubhi".equals(user) && "shubhi231".equals(pwd))
			isAdmin = true;
		access = new CommandAccessImpl();
	}

	@Override
	public Process runService(String cmd) throws Exception {
		Process p = null;
		if(isAdmin) {
			p = access.runService(cmd);
		} else {
			if(cmd.trim().startsWith("exe")) {
				throw new Exception("exe command is not " + "allowed for non-admin users");
			} else {
				if(cmd.trim().startsWith("exe")) {
					throw new Exception("exe command is not " + "allowed for non-admin users");
				} else {
					p = access.runService(cmd);
				}
			}
		}
		return p;
	}
	
	
}
