package io.hgdb.client.cxf.business.bpm;

import io.hgdb.client.cxf.WsClient;
import pro.ibpm.mercury.business.SecretaryManager;
import pro.ibpm.mercury.context.ContextHelper;
import pro.ibpm.mercury.entities.data.MUser;
import pro.ibpm.mercury.exceptions.MercuryException;
import pro.ibpm.mercury.ws.server.api.actions.business.bpm.IBpmTaskBufferSecretaryManagerAction;

public class BpmTaskBufferSecretaryManager extends WsClient<IBpmTaskBufferSecretaryManagerAction>
		implements SecretaryManager {

	@Override
	public void wakeup() {
		try {
			checkWsStatus(getService()
					.wakeupSecretary(ContextHelper.createContext(MUser.DEFAULT_SYSTEM_USER_NAME, createComment())));
		} catch (MercuryException e) {
			logger.error("-->wakeupSecretary", e);
		}
	}

	@Override
	public boolean isWorking() {
		try {
			String result = getValue(getService()
					.isWorking(ContextHelper.createContext(MUser.DEFAULT_SYSTEM_USER_NAME, createComment())));
			return Boolean.parseBoolean(result);
		} catch (MercuryException e) {
			logger.error("-->isWorking", e);
		}
		return false;
	}

}
