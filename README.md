# Kube-App

##if you haven't already enable hyper-v
Enable-WindowsOptionalFeature -Online -FeatureName Microsoft-Hyper-V -All

##forces the minikube ip to be 172.21.3.173
##netsh interface ip set address name="vEthernet (Default Switch)" static 172.21.3.173 255.255.255.0 none

##start minikube (use powershell as administrator)
minikube start --driver=hyperv 

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



##top value for build, bottom for out of minikube testing
mongodb://mongodb-service:8000/employees
mongodb://localhost:27017/employees

