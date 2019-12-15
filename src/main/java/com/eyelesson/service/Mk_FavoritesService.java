package com.eyelesson.service;

import com.eyelesson.dao.Mk_FavoritesDAO;
import com.eyelesson.entity.Mk_Favorites;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Mk_FavoritesService {

    @Resource
    Mk_FavoritesDAO mkFavoritesDAO;

    //如果有数据就取消点赞 如果没有就点赞
    public int UpdateFavorites(int mknid,int mkuid)
    {
        Mk_Favorites mkfav = mkFavoritesDAO.mkfav(mknid, mkuid);
        System.out.println(mkfav);
        if(mkfav==null)
        {
            Mk_Favorites mkfas = mkFavoritesDAO.mkfas(mkuid);
            System.out.println(mkfas);
            if(mkfas==null)
            {
                return mkFavoritesDAO.InsertFav(mknid,mkuid);
            }
            return mkFavoritesDAO.Updatemknid(mknid,mkuid);
        }
        return mkFavoritesDAO.CencalFav(mknid);
    }

    //评论点赞
    public int UpdayeFav(int mkuid,int mkcmid)
    {
        Mk_Favorites fav = mkFavoritesDAO.findPFav(mkuid, mkcmid);
        if(fav==null)
        {
            Mk_Favorites fav1 = mkFavoritesDAO.findUpdateFav(mkuid);
            if(fav1==null)
            {
                Mk_Favorites fav3 = mkFavoritesDAO.findPFav(mkuid, mkcmid);
                if(fav3==null)
                {
                    return mkFavoritesDAO.insertFav(mkuid,mkcmid);
                }
                return mkFavoritesDAO.Ufav(mkcmid,mkuid);
            }
            return mkFavoritesDAO.Ufav(mkcmid,mkuid);
        }
        return mkFavoritesDAO.UpdatePFav(mkuid,mkcmid);

    }

}
