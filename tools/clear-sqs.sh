#!/bin/zsh
# SQS queue URL
QUEUE_URL="http://localhost:4566/000000000000/sample-queue"

# Receive a message from the SQS queue
RECEIVE_OUTPUT=$(aws --endpoint-url=http://localhost:4566 sqs receive-message --queue-url $QUEUE_URL)
echo $RECEIVE_OUTPUT

# Extract the receipt handle from the output
RECEIPT_HANDLE=$(echo $RECEIVE_OUTPUT | jq -r '.Messages[0].ReceiptHandle')

# Delete the message from the SQS queue
aws --endpoint-url=http://localhost:4566 sqs delete-message --queue-url $QUEUE_URL --receipt-handle "$RECEIPT_HANDLE"