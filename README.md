# Kube-App

##if you haven't already, enable hyper-v
Enable-WindowsOptionalFeature -Online -FeatureName Microsoft-Hyper-V -All

##start minikube (use powershell as administrator)
minikube start --driver=hyperv 

##enables ingress and ingress-dns in minikube
minikube addons enable ingress
minikube addons enable ingress-dns

#creates DNS rule for current minikube IP
Get-DnsClientNrptRule | Where-Object {$_.Namespace -eq '.test'} | Remove-DnsClientNrptRule -Force; Add-DnsClientNrptRule -Namespace ".test" -NameServers "$(minikube ip)"


##open docker insider the minikube enviroment
& minikube -p minikube docker-env --shell powershell | Invoke-Expression

& minikube -p minikube docker-env | Invoke-Expression

##navigate to inside the /kube-app directory

##build the docker images for each part of the app

docker build -t client-kube client-kube

docker build -t server-kube server-kube

docker build -t mongodb .

kubectl apply -f k8s

minikube services --all



##URL for mongo database: top value for build, bottom for out of minikube testing
mongodb://mongodb-service:8000/employees
mongodb://localhost:27017/employees

