// Copyright 2017 Amazon Web Services, Inc. or its affiliates. All rights reserved.
package com.amazonaws.lab_dev_assoc;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import java.util.List;

// The ReadySetGo class lists the number of buckets in your account.
public class ReadySetGo {

  // Before running the code, check that the ~/.aws/credentials file contains your credentials.

  static AmazonS3 s3;
  public static final Region BUCKET_REGION = Utils.getRegion();

  public static void main(String[] args) throws Exception {

    System.out.println("============================================");
    System.out.println("Welcome to the AWS Java SDK! Ready, Set, Go!");
    System.out.println("============================================");

    try {
      // Create AmazonS3Client
      // The AmazonS3Client will automatically retrieve the credential profiles file at the default location (~/.aws/credentials)
      s3 = new AmazonS3Client();
      s3.setRegion(BUCKET_REGION);

      // List all Amazon S3 buckets that the authenticated sender of the request owns.
      List<Bucket> buckets = s3.listBuckets();

      System.out.println("You have " + buckets.size() + " Amazon S3 buckets.");
    } catch (AmazonServiceException ase) {
      System.out.println("Error Message:    " + ase.getMessage());
      System.out.println("HTTP Status Code: " + ase.getStatusCode());
      System.out.println("AWS Error Code:   " + ase.getErrorCode());
      System.out.println("Error Type:       " + ase.getErrorType());
      System.out.println("Request ID:       " + ase.getRequestId());
    } catch (AmazonClientException ace) {
      System.out.println("Error Message: " + ace.getMessage());
    }
  }
}
