package com.ani.client.agent.device.core.message;


import com.ani.client.agent.device.core.device.DeviceMaster;

import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 * Created by huangbin on 10/23/15.
 */
public class ContentUpdateRequest extends MessageContent {
    public DeviceMaster deviceMaster;

    public ContentUpdateRequest() {
    }

    public ContentUpdateRequest(DeviceMaster deviceMaster) {
        this.deviceMaster = deviceMaster;
    }

    @Override
    public void serializeByte(DataOutputStream dos) throws Exception {
        deviceMaster.serializeByte(dos);
    }

    @Override
    public void unserializeByte(DataInputStream dis) throws Exception {
    }
}