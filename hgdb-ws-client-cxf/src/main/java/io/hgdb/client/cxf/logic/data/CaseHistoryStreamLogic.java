package io.hgdb.client.cxf.logic.data;

import java.util.List;

import io.hgdb.client.cxf.logic.WsClientDataLogic;
import pro.ibpm.mercury.context.Context;
import pro.ibpm.mercury.entities.beans.EntityList;
import pro.ibpm.mercury.entities.data.CaseHistoryStream;
import pro.ibpm.mercury.exceptions.MercuryException;
import pro.ibpm.mercury.logic.api.data.ICaseHistoryStreamLogic;
import pro.ibpm.mercury.ws.server.api.actions.data.ICaseHistoryStreamAction;

/**
 * @author Karol Kowalczyk
 * 
 */
public class CaseHistoryStreamLogic extends WsClientDataLogic<CaseHistoryStream, Long, ICaseHistoryStreamAction>
		implements ICaseHistoryStreamLogic {

	private static final long serialVersionUID = -2017969288028348196L;

	@Override
	public CaseHistoryStream insert(Context context, final CaseHistoryStream e) throws MercuryException {
		return getEntity(context, getService().insert(context, e));
	}

	@Override
	public EntityList<CaseHistoryStream, Long> insertList(Context context, List<CaseHistoryStream> eBag)
			throws MercuryException {
		return getEntityCollection(context, getService().insertBag(context, eBag));
	}

	@Override
	public Long remove(Context context, final CaseHistoryStream e) throws MercuryException {
		return getId(getService().remove(context, e), e);
	}

	@Override
	public List<Long> removeList(Context context, final List<CaseHistoryStream> eBag) throws MercuryException {
		return getIds(getService().removeBag(context, eBag), eBag);
	}

	@Override
	public CaseHistoryStream find(Context context, final Long pk) throws MercuryException {
		return getEntity(context, getService().findByKey(context, pk));
	}

	@Override
	public CaseHistoryStream findFirst(Context context) throws MercuryException {
		return getEntity(context, getService().findFirst(context));
	}

	@Override
	public CaseHistoryStream update(Context context, CaseHistoryStream e) throws MercuryException {
		return getEntity(context, getService().update(context, e));
	}

	@Override
	public EntityList<CaseHistoryStream, Long> updateList(Context context, List<CaseHistoryStream> eBag)
			throws MercuryException {
		return getEntityCollection(context, getService().updateBag(context, eBag));
	}

	@Override
	public List<CaseHistoryStream> filter(Context context, CaseHistoryStream e) throws MercuryException {
		return getEntityCollection(context, getService().filter(context, e));
	}

	@Override
	public List<CaseHistoryStream> findByIdList(Context context, List<Long> idList) throws MercuryException {
		return getEntityCollection(context, getService().findByKeyBag(context, idList));
	}

	@Override
	public List<CaseHistoryStream> findByCaseId(Context context, Long caseId) throws MercuryException {
		return getEntityCollection(context, getService().findByCaseId(context, caseId));
	}

	@Override
	public List<CaseHistoryStream> findAll(Context context) throws MercuryException {
		return getEntityCollection(context, getService().findAll(context));
	}

}
