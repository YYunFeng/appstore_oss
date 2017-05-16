package com.jd.cms.manager.systemmaintenance.impl;

import com.jd.cms.dao.systemmaintenance.AndroidDriverDao;
import com.jd.cms.domain.systemmaintenance.AndroidDriver;
import com.jd.cms.manager.contains.SequenceConstants;
import com.jd.cms.manager.systemmaintenance.AndroidDriverManager;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.BaseQuery;
import com.jd.common.util.base.PaginatedArrayList;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-9-5
 * Time: 下午12:04
 * To change this template use File | Settings | File Templates.
 */
public class AndroidDriverManagerImpl extends BaseManager implements AndroidDriverManager{
    private AndroidDriverDao androidDriverDao;

    public AndroidDriverDao getAndroidDriverDao() {
        return androidDriverDao;
    }

    public void setAndroidDriverDao(AndroidDriverDao androidDriverDao) {
        this.androidDriverDao = androidDriverDao;
    }

    public PaginatedList<AndroidDriver> findAndroidDriver(int pageIndex, int pageSize) {
        if (0 == pageIndex) pageIndex = 1;
        PaginatedList<AndroidDriver> androidDrivers = new PaginatedArrayList<AndroidDriver>(pageIndex, pageSize);
        try {
            BaseQuery baseQuery = new BaseQuery();
            int totalItem = androidDriverDao.getAndroidDriverCount();
            androidDrivers.setTotalItem(totalItem);
            baseQuery.setStartRow((pageIndex - 1) * pageSize);
            baseQuery.setEndRow(pageSize);
            List<AndroidDriver> androidDriver = androidDriverDao.findAndroidDriver(baseQuery);
            androidDrivers.addAll(androidDriver);
        } catch (Exception ex) {

            throw new RuntimeException("findAndroidDriver error!", ex);
        }

        return androidDrivers;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void deleteAndroidDriver(AndroidDriver androidDriver) {
        androidDriverDao.deleteAndroidDriver(androidDriver);
    }

    public void createAndroidDriver(final AndroidDriver androidDriver) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    int androidDriverId = (int) sequenceUtil.get(SequenceConstants.CMS_ANDROID_DRIVER_SEQUENCE);
                    androidDriver.setId(androidDriverId);
                    androidDriverDao.createAndroidDriver(androidDriver);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();

                }
            }
        });
    }

    public AndroidDriver findAndroidDriverById(AndroidDriver android) {
        AndroidDriver androidDriver = androidDriverDao.findAndroidDriverById(android);
        return androidDriver;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateAndroidDriver(AndroidDriver androidDriver) {
        androidDriverDao.updateAndroidDriver(androidDriver);
    }
}
