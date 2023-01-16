$prevPwd = $PWD; Set-Location -ErrorAction Stop -LiteralPath $PSScriptRoot

try {
##start minikube (use powershell as administrator), IP :172.21.3.173
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
 $PWD  # output the current location 
}
finally {
  # Restore the previous location.
  $prevPwd | Set-Location
}