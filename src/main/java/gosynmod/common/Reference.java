package gosynmod.common;

import gosynmod.proxy.ClientProxy;
import gosynmod.proxy.CommonProxy;

public class Reference {
	public static final String MOD_ID = "gosyn";
	public static final String NAME = "Gosyn";
	public static final String VERSION = "0.1";
	public static final String ACCEPTED_VERSION = "[1.12.2]";
	public static final String CLIENT_PROXY_CLASS = "gosynmod.proxy.ClientProxy";
	public static final String COMMOM_PROXY_CLASS = "gosynmod.proxy.CommonProxy";
	public static final CommonProxy PROXY = new ClientProxy();


}