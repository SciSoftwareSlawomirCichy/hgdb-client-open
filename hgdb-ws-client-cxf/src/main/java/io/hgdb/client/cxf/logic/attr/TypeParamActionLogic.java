package io.hgdb.client.cxf.logic.attr;

import java.util.Collection;
import java.util.List;

import io.hgdb.client.cxf.logic.WsClientDataLogic;
import pro.ibpm.mercury.context.Context;
import pro.ibpm.mercury.entities.attr.TypeParamAction;
import pro.ibpm.mercury.entities.beans.EntityList;
import pro.ibpm.mercury.exceptions.MercuryException;
import pro.ibpm.mercury.logic.api.attr.ITypeParamActionLogic;
import pro.ibpm.mercury.ws.server.api.actions.attr.ITypeParamActionAction;

/**
 * @author Karol Kowalczyk
 * 
 */
public class TypeParamActionLogic extends
		WsClientDataLogic<TypeParamAction, Long, ITypeParamActionAction>
		implements ITypeParamActionLogic {

	private static final long serialVersionUID = -3715834274212585000L;

	@Override
	public TypeParamAction insert(Context context, final TypeParamAction e)
			throws MercuryException {
		return getEntity(context, getService().insert(context, e));
	}

	@Override
	public EntityList<TypeParamAction, Long> insertList(Context context,
			List<TypeParamAction> eBag) throws MercuryException {
		return getEntityCollection(
				context,
				getService().insertBag(context,
						(Collection<TypeParamAction>) eBag));
	}

	@Override
	public Long remove(Context context, final TypeParamAction e)
			throws MercuryException {
		return getId(getService().remove(context, e), e);
	}

	@Override
	public List<Long> removeList(Context context,
			final List<TypeParamAction> eBag) throws MercuryException {
		return getIds(
				getService().removeBag(context,
						(Collection<TypeParamAction>) eBag), eBag);
	}

	@Override
	public List<TypeParamAction> findAll(Context context)
			throws MercuryException {
		return (List<TypeParamAction>) getEntityCollection(context,
				getService().findAll(context));
	}

	@Override
	public TypeParamAction find(Context context, final Long pk)
			throws MercuryException {
		return getEntity(context, getService().findByKey(context, pk));
	}

	@Override
	public TypeParamAction findFirst(Context context) throws MercuryException {
		return getEntity(context, getService().findFirst(context));
	}

	@Override
	public TypeParamAction update(Context context, TypeParamAction e)
			throws MercuryException {
		return getEntity(context, getService().update(context, e));
	}

	@Override
	public EntityList<TypeParamAction, Long> updateList(Context context,
			List<TypeParamAction> eBag) throws MercuryException {
		return getEntityCollection(
				context,
				getService().updateBag(context,
						(Collection<TypeParamAction>) eBag));
	}

	@Override
	public List<TypeParamAction> findByIdList(Context context, List<Long> idList)
			throws MercuryException {
		return (List<TypeParamAction>) getEntityCollection(context,
				getService().findByKeyBag(context, (Collection<Long>) idList));
	}

	@Override
	public List<TypeParamAction> filter(Context context, TypeParamAction e)
			throws MercuryException {
		return (List<TypeParamAction>) getEntityCollection(context,
				getService().filter(context, e));
	}

}
