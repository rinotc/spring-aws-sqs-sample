#!/bin/zsh
# Create a SQS queue
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name sample-queue --region ap-northeast-1