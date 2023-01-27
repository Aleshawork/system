cd oc-deployment/k8s/myservice

kubectl create namespace myapp
kubectl config set-context --current --namespace=myapp
kubectl apply -f dc.yaml
kubectl apply -f svc.yaml
minikube tunnel

