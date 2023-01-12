# Kube-App

##if you haven't already enable hyper-v
Enable-WindowsOptionalFeature -Online -FeatureName Microsoft-Hyper-V -All

##start minikube (use powershell as administrator)
minikube start --driver=hyperv 172.21.3.173

##open docker insider the minikube enviroment
& minikube -p minikube docker-env --shell powershell | Invoke-Expression

& minikube -p minikube docker-env | Invoke-Expression

##navigate to inside the /kube-app directory

##build the docker images for each part of the app

docker build -t client-kube client-kube



##top value for build, bottom for out of minikube testing
mongodb://mongodb-service:8000/employees
mongodb://localhost:27017/employees