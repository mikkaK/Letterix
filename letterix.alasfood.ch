server {

    root /var/www/html/letterix.alasfood.ch;

    access_log /var/log/nginx/letterix.access.log;
    # Add index.php to the list if you are using PHP
    index index.html index.htm index.nginx-debian.html;

    server_name letterix.alasfood.ch www.letterix.alasfood.ch;

    location / {
        proxy_pass http://localhost:3235/;
    }
    location /api/ {
        proxy_pass http://localhost:8060/;
        proxy_read_timeout 10000;
        proxy_connect_timeout 10000;
        proxy_send_timeout 10000;
    }



    listen 443 ssl; # managed by Certbot
    ssl_certificate /etc/letsencrypt/live/letterix.alasfood.ch/fullchain.pem; #>
    ssl_certificate_key /etc/letsencrypt/live/letterix.alasfood.ch/privkey.pem;>
    include /etc/letsencrypt/options-ssl-nginx.conf; # managed by Certbot
    ssl_dhparam /etc/letsencrypt/ssl-dhparams.pem; # managed by Certbot


}

server {
    if ($host = www.letterix.alasfood.ch) {
        return 301 https://$host$request_uri;
    } # managed by Certbot


    listen 80;
    server_name letterix.alasfood.ch www.letterix.alasfood.ch;
    return 301 https://$host$request_uri;


}

server {
    if ($host = letterix.alasfood.ch) {
        return 301 https://$host$request_uri;
    } # managed by Certbot

