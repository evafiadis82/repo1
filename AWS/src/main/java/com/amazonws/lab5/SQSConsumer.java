package com.amazonws.lab5;
// Copyright 2017 Amazon Web Services, Inc. or its affiliates. All rights reserved.

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

// The SQSConsumer class retrieves messages from an SQS queue
public class SQSConsumer implements Runnable {

  public static final Region REGION = Utils.getRegion();
  public static final String QUEUE_NAME = "MySQSQueue_A";
  public static final long SLEEP = 500;
  private static AmazonSQSClient sqsClient = null;

  public static void main(String[] args) throws Exception {
    SQSConsumer sqsConsumer = new SQSConsumer();
    sqsConsumer.init();
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    ScheduledFuture<?> future =
        executor.scheduleWithFixedDelay(sqsConsumer, 0, SLEEP, TimeUnit.MILLISECONDS);
    Thread.sleep(20 * SLEEP);
    future.cancel(false);
    executor.shutdown();
  }

  private void init() throws Exception {
    AWSCredentials credentials = null;
    try {
      credentials = new ProfileCredentialsProvider().getCredentials();
    } catch (Exception e) {
      throw new AmazonClientException(
          "Cannot load the credentials from the credential profiles file. "
              + "Please make sure that your credentials file is at the correct "
              + "location (~/.aws/credentials), and is in valid format.",
          e);
    }

    createSQSClient(credentials);
  }

  public void run() {
    System.out.println("SQSConsumer Thread running!");
    consumeMessages();
  }

  private void consumeMessages() {
    try {
      Order order = null;
      String queueUrl = null;
      Map<String, String> messageAttributes = null;
      // Should contain result returned by the receiveMessage call
      ReceiveMessageResult receiveMessageResult = null;

      // Should contain messages retrieved from the ReceiveMessageResult object
      List<Message> messages = null;

      queueUrl = getURL();
      ReceiveMessageRequest request = createRequest(queueUrl);
      receiveMessageResult = getMessageResult(request);
      messages = getMessages(receiveMessageResult);

      System.out.printf("Number of messages received this time: %d%n", messages.size());

      ObjectMapper mapper = new ObjectMapper();

      for (Message message : messages) {
        messageAttributes = message.getAttributes();
        order = mapper.readValue(message.getBody(), Order.class);
        // Adds message metadata to Order object
        order.setSenderId(messageAttributes.get("SenderId"));
        order.setSentTimestamp(messageAttributes.get("SentTimestamp"));

        System.out.printf("Order received from SQS queue:%s%n", order);

        deleteMessage(queueUrl, message);
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  /**
   * Create an instance of the AmazonSNSClient class
   *
   * @param credentials   AWS Credentials
   */
  private static void createSQSClient(AWSCredentials credentials) {
    // STUDENT TODO 7: Replace the solution with your own code
    sqsClient = Solution.createSQSClient(sqsClient, credentials, REGION);
  }

  /**
   * Retrieve the URL of the SQS queue
   *
   * @return    URL
   */
  private static String getURL() {
    // STUDENT TODO 8: Replace the solution with your own code
    return Solution.getURL(sqsClient, QUEUE_NAME);
  }

  /**
   * Create an instance of the ReceiveMessageRequest class
   *
   * @param queueUrl    Queue URL
   * @return            ReceiveMessageRequest object
   */
  private static ReceiveMessageRequest createRequest(String queueUrl) {
    // STUDENT TODO 9: Replace the solution with your own code
    ReceiveMessageRequest request = Solution.createRequest(queueUrl);
    return request;
  }

  /**
   * Receive messages from the SQS queue
   *
   * @param request   ReceiveMessageRequest object
   * @return          ReceiveMessageResult object
   */
  private static ReceiveMessageResult getMessageResult(ReceiveMessageRequest request) {
    // STUDENT TODO 10: Replace the solution with your own code
    return Solution.getMessageResult(sqsClient, request);
  }

  /**
   * Retrieve all messages from ReceiveMessageResult
   *
   * @param receiveMessageResult  ReceiveMessageResult object
   * @return                      List of messages
   */
  private static List<Message> getMessages(ReceiveMessageResult receiveMessageResult) {
    // STUDENT TODO 11: Replace the solution with your own code
    return Solution.getMessages(receiveMessageResult);
  }

  /**
   * Delete the message from the queue
   *
   * @param queueUrl  URL
   * @param message   Message
   */
  private void deleteMessage(String queueUrl, Message message) {
    // STUDENT TODO 12: Replace the solution with your own code
    Solution.deleteMessage(sqsClient, queueUrl, message);
  }
}
