[![](https://tokei.rs/b1/github/b4456609/movie-uat)](https://github.com/b4456609/movie-uat).
# movie-uat

env
```
export ZUUL_URL=http://localhost:8080/
```

```sh
docker run --rm \
    -e MGP=localhost:4000 \ 
    -e ZUUL_URL=http://localhost:8080/ \
    -e TARGET=theater\
    b4456609/movie-uat
```