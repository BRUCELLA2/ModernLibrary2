
FROM ubuntu:latest
MAINTAINER BRUCELLA2@ModernLibrary

# Add crontab file in the cron directory
ADD crontab /etc/cron.d/reminder-cron
ADD borrowExpired.xml opt/scripts/borrowExpired.xml
ADD reminderBeforeExpiration.xml opt/scripts/reminderBeforeExpiration.xml
ADD checkReservation.xml opt/scripts/checkReservation.xml


# Give execution rights on the cron job
RUN chmod 0644 /etc/cron.d/reminder-cron

# Create the log file to be able to run tail
RUN touch /var/log/cron.log

#Install Cron
RUN apt-get update
RUN apt-get -y install cron

#Install curl
RUN apt-get -y install curl

# Run the command on container startup
CMD cron && tail -f /var/log/cron.log