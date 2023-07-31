#!/bin/bash

minikube start
kubectl create namespace myapp
kubectl config set-context --current --namespace=myapp

cd oc-deployment/k8s/myservice
kubectl apply -f dc.yaml
kubectl apply -f svc.yaml

cd ..
cd innerservice
kubectl apply -f dc.yaml
kubectl apply -f svc.yaml

minikube tunnel

cd ..
kubectl apply -f ingress.yaml

