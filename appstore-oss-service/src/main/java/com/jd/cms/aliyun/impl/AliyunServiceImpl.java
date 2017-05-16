package com.jd.cms.aliyun.impl;

import com.aliyun.openservices.ClientConfiguration;
import com.aliyun.openservices.oss.OSSClient;
import com.aliyun.openservices.oss.OSSException;
import com.aliyun.openservices.oss.model.CopyObjectResult;
import com.aliyun.openservices.oss.model.ObjectMetadata;
import com.aliyun.openservices.oss.model.PutObjectResult;
import com.jd.cms.aliyun.AliyunService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 该接口为阿里云的开放存储接口
 */
public class AliyunServiceImpl implements AliyunService {
    private String bucketName;
    private String accessKeyId;
    private String accessKeySecret;
    private String tempBucketName;
    private String endpoint;

    private static final Log logger = LogFactory.getLog(AliyunServiceImpl.class);


    public void createBucket(String bucketName) {
        OSSClient ossClient = new OSSClient(accessKeyId, accessKeySecret);
        ossClient.createBucket(bucketName);
    }

    /**
     * 上传一个Object
     *
     * @param filePath
     * @return
     */
    public String putObject(String filePath, String key, int flag) throws FileNotFoundException {
        // 创建ClientConfiguration实例
        ClientConfiguration conf = new ClientConfiguration();
        conf.setSocketTimeout(2000);
        conf.setConnectionTimeout(3000);
        conf.setMaxErrorRetry(3);
        // 初始化OSSClient
        OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret, conf);
        logger.info("endpoint:" + endpoint);
        logger.info("上传文件目录：" + filePath);
        logger.info("上传文件名：" + key);
        // 获取指定文件的输入流
        File file = new File(filePath);
        InputStream content = new FileInputStream(file);

        // 创建上传Object的Metadata
        ObjectMetadata meta = new ObjectMetadata();

        // 必须设置ContentLength
        meta.setContentLength(file.length());
        // 上传Object
        PutObjectResult result = null;
        if (flag == 0) {   // 上传到正式的Bucket
            result = client.putObject(bucketName, key, content, meta);
            logger.info("上传正式文件成功");
        } else if (flag == 1) { // 上传到临时的Bucket
            result = client.putObject(tempBucketName, key, content, meta);
            logger.info("上传正式文件成功");
        }
        // 打印ETag
        String eTag = result.getETag();
        logger.info(eTag);
        return eTag;
    }

    public CopyObjectResult copyObject(String key, String destinationKey) throws Exception {
        ClientConfiguration conf = new ClientConfiguration();
        conf.setSocketTimeout(2000);
        conf.setConnectionTimeout(3000);
        conf.setMaxErrorRetry(3);
        OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret, conf);
        boolean isCopy = false;
        try {
            if (client.getObjectMetadata(tempBucketName, key).getETag() != null) {
                isCopy = true;
            }
        } catch (OSSException e) {
            if (e.getErrorCode().equals("NoSuchKey")) {
                isCopy = false;
                logger.info("不存在临时文件");
            } else {
                e.printStackTrace();
            }
        }
        if (isCopy) {
            CopyObjectResult copyObjectResult = client.copyObject(tempBucketName, key, bucketName, destinationKey);
            logger.info("拷贝成功");
            logger.info("eTag:" + copyObjectResult.getETag());
            return copyObjectResult;
        }
        return null;
    }


    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }


    public String getTempBucketName() {
        return tempBucketName;
    }

    public void setTempBucketName(String tempBucketName) {
        this.tempBucketName = tempBucketName;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
