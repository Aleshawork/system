#!/bin/bash
cd oc-deployment/k8s/myservice

minikube stop
minikube start
kubectl create namespace myapp
kubectl config set-context --current --namespace=myapp
kubectl apply -f dc.yaml
kubectl apply -f svc.yaml
minikube tunnel

