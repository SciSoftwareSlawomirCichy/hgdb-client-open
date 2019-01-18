package io.hgdb.client.cxf.logic.data;

import java.util.List;

import io.hgdb.client.cxf.logic.WsClientBigDataLogic;
import pro.ibpm.mercury.context.Context;
import pro.ibpm.mercury.dto.paging.PageTransportable;
import pro.ibpm.mercury.entities.beans.EntityList;
import pro.ibpm.mercury.entities.data.QuickTask;
import pro.ibpm.mercury.exceptions.MercuryException;
import pro.ibpm.mercury.logic.api.data.IQuickTaskLogic;
import pro.ibpm.mercury.logic.paging.IPage;
import pro.ibpm.mercury.logic.paging.IPagedResult;
import pro.ibpm.mercury.ws.server.api.actions.data.IQuickTaskAction;
import pro.ibpm.mercury.ws.server.api.returns.IWsStatusWithPagedResult;

/**
 * @author Karol Kowalczyk
 * 
 */
public class QuickTaskLogic extends WsClientBigDataLogic<QuickTask, Long, IQuickTaskAction> implements IQuickTaskLogic {

	private static final long serialVersionUID = -7374883169777430742L;

	@Override
	public QuickTask insert(Context context, final QuickTask e) throws MercuryException {
		return getEntity(context, getService().insert(context, e));
	}

	@Override
	public EntityList<QuickTask, Long> insertList(Context context, List<QuickTask> eBag) throws MercuryException {
		return getEntityCollection(context, getService().insertBag(context, eBag));
	}

	@Override
	public Long remove(Context context, final QuickTask e) throws MercuryException {
		return getId(getService().remove(context, e), e);
	}

	@Override
	public List<Long> removeList(Context context, final List<QuickTask> eBag) throws MercuryException {
		return getIds(getService().removeBag(context, eBag), eBag);
	}

	@Override
	public QuickTask find(Context context, final Long pk) throws MercuryException {
		return getEntity(context, getService().findByKey(context, pk));
	}

	@Override
	public QuickTask findFirst(Context context) throws MercuryException {
		return getEntity(context, getService().findFirst(context));
	}

	@Override
	public QuickTask update(Context context, QuickTask e) throws MercuryException {
		return getEntity(context, getService().update(context, e));
	}

	@Override
	public EntityList<QuickTask, Long> updateList(Context context, List<QuickTask> eBag) throws MercuryException {
		return getEntityCollection(context, getService().updateBag(context, eBag));
	}

	@Override
	public List<QuickTask> findByIdList(Context context, List<Long> idList) throws MercuryException {
		return getEntityCollection(context, getService().findByKeyBag(context, idList));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public IPagedResult<QuickTask, IPage> filterPaged(Context context, QuickTask e, IPage page)
			throws MercuryException {
		return getPagedResult(context,
				(IWsStatusWithPagedResult) getService().filterPaged(context, e, (PageTransportable) page));
	}

	@Override
	public List<QuickTask> findAll(Context context) throws MercuryException {
		return getEntityCollection(context, getService().findAll(context));
	}

}
