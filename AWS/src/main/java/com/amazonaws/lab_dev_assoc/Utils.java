// Copyright 2017 Amazon Web Services, Inc. or its affiliates. All rights reserved.

package com.amazonaws.lab_dev_assoc;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;

public class Utils {

  public static Region getRegion() {
    Region region = Regions.getCurrentRegion();

    // For local testing only
    if (region == null) {
      //region = Region.getRegion(Regions.US_WEST_1);
    	region = Region.getRegion(Regions.EU_CENTRAL_1);
    }

    System.out.printf("getRegion returns %s\n ", region.getName());
    return region;
  }
  
  public static ClientConfiguration getProxy()
  {
	  
	  ClientConfiguration clientCfg = new ClientConfiguration();
	    clientCfg.setProtocol(Protocol.HTTP);

	    //setup proxy connection:
	    clientCfg.setProxyHost("proxy.ote.gr");
	    clientCfg.setProxyPort(80);
	    
	    return clientCfg;

	  
  }
}
