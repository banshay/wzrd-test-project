# wzrd-test-project

One time setup:
```shell
gcloud auth configure-docker europe-west6-docker.pkg.dev
```


### Build the app
```shell
docker build . -t wzrd-test-project
```
```shell
docker tag wzrd-test-project europe-west6-docker.pkg.dev/tabz-cloud/wzrd/wzrd-test-project:latest
```
```shell
docker push europe-west6-docker.pkg.dev/tabz-cloud/wzrd/wzrd-test-project:latest
```
