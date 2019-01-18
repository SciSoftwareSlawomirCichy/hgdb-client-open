package io.hgdb.client.cxf.logic.data;

import java.util.List;

import io.hgdb.client.cxf.logic.WsClientDataLogic;
import pro.ibpm.mercury.context.Context;
import pro.ibpm.mercury.entities.beans.EntityList;
import pro.ibpm.mercury.entities.data.SystemUser;
import pro.ibpm.mercury.exceptions.MercuryException;
import pro.ibpm.mercury.logic.api.data.ISystemUserLogic;
import pro.ibpm.mercury.ws.server.api.actions.data.ISystemUserAction;

/**
 * @author Karol Kowalczyk
 * 
 */
public class SystemUserLogic extends WsClientDataLogic<SystemUser, Long, ISystemUserAction>
		implements ISystemUserLogic {

	private static final long serialVersionUID = 1918388715452987539L;

	@Override
	public SystemUser insert(Context context, final SystemUser e) throws MercuryException {
		return getEntity(context, getService().insert(context, e));
	}

	@Override
	public EntityList<SystemUser, Long> insertList(Context context, List<SystemUser> eBag) throws MercuryException {
		return getEntityCollection(context, getService().insertBag(context, eBag));
	}

	@Override
	public Long remove(Context context, final SystemUser e) throws MercuryException {
		return getId(getService().remove(context, e), e);
	}

	@Override
	public List<Long> removeList(Context context, final List<SystemUser> eBag) throws MercuryException {
		return getIds(getService().removeBag(context, eBag), eBag);
	}

	@Override
	public SystemUser find(Context context, final Long pk) throws MercuryException {
		return getEntity(context, getService().findByKey(context, pk));
	}

	@Override
	public SystemUser findFirst(Context context) throws MercuryException {
		return getEntity(context, getService().findFirst(context));
	}

	@Override
	public SystemUser update(Context context, SystemUser e) throws MercuryException {
		return getEntity(context, getService().update(context, e));
	}

	@Override
	public EntityList<SystemUser, Long> updateList(Context context, List<SystemUser> eBag) throws MercuryException {
		return getEntityCollection(context, getService().updateBag(context, eBag));
	}

	@Override
	public List<SystemUser> findByIdList(Context context, List<Long> idList) throws MercuryException {
		return getEntityCollection(context, getService().findByKeyBag(context, idList));
	}

	@Override
	public List<SystemUser> filter(Context context, SystemUser e) throws MercuryException {
		return getEntityCollection(context, getService().filter(context, e));
	}

	@Override
	public SystemUser findByLogin(Context context, String login) throws MercuryException {
		return getEntity(context, getService().findByLogin(context, login));
	}

	@Override
	public List<SystemUser> getAllRealUsers(Context context) throws MercuryException {
		return getEntityCollection(context, getService().getAllRealUsers(context));
	}

	@Override
	public List<SystemUser> getAllTechnicalUsers(Context context) throws MercuryException {
		return getEntityCollection(context, getService().getAllTechnicalUsers(context));
	}

	@Override
	public List<SystemUser> findAll(Context context) throws MercuryException {
		return getEntityCollection(context, getService().findAll(context));
	}
}
