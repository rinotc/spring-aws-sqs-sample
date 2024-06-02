#!/bin/zsh

# SQS queue URL
QUEUE_URL="http://localhost:4566/000000000000/sample-queue"

# Message body from the script argument
MESSAGE_BODY=$1

# Send the message to SQS queue
aws --endpoint-url=http://localhost:4566 sqs send-message --queue-url $QUEUE_URL --message-body $MESSAGE_BODY --region ap-northeast-1