# Lambda_Templates
This lambda API Template will provide all of the code in order to provision a lambda function that will get external data via API then Save to an S3 bucket

Pre:
Have AWS ECR Ready to go
Have docker installed and ready to go
Terraform cli installed

1. Copy the code from this repo into a new project for easy use

2. Create a new repo for your new project, set up your repo secrets. You wil need to set up your repo secrets for 
AWS_ACCOUNT_ID
AWS_ACCESS_KEY_ID
AWS_SECRET_ACCESS_KEY
DOCKER_USERNAME
DOCKER_PASSWORD
AWS_REGION

3. Copy the code from this repo into your new repo and fill out everything under SRC.

4. VErify your branch is listed under ci.yml. After that, commit changes to github. This wil create the docker image and push to aws ecr if done properly

5. Open up a new terminal, and provision the lambda resource(Attached to this repo).

6. Test the lambda, ensure it is working as you expected - copy paste lambda url to postman use get request and it should trigger. If not, view cloudwatch logs


