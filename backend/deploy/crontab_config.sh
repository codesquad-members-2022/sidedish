# back script - At every 3rd minute
*/3 * * * * /home/ubuntu/back_deploy.sh >> log/back_log.txt 2>&1

# front script - At every 3rd minute
*/3 * * * * /home/ubuntu/front_deploy.sh >> log/front_log.txt 2>&1


