# rest-example-project
rest-example-project

# Alınan Notlar
```
* Kurulum Notları
* Soap Servisi projesinde java 1.8 kullanılmıstır.
* Window -> Preferance -> Java -> InstalledJRE's ->java jdk 1.8 gösterilir
    Add -> C:\Program Files\Java\jdk1.8.0_231 yapılır sts versiyonu remove edilerek apply and close yapılır.
* Maven Update yapılır (Alt+F5)yada proje sagtık maven -> update project
* Proje sagtık ->Run -> Maven build tıklanır 
    clean install yazılıp skip test tiklenerek aplly basılır sonra runa basılarak maven clean install işlemi yapılır.
* Projeyi spring bootda ayaga kaldırmak icin proje sagtık -> Run -> Spring Boot Application tıklanarak uygulama ayaga kaldırılır.


Gitten çekildikten sonra 

* Uygulama Notları
Methodlar
    POST -> http://localhost:8086/users/add
    GET -> http://localhost:8086/users/all
    GET -> http://localhost:8086/users/surname?surname=Kahraman
    GET -> http://localhost:8086/users/:id
    GET -> http://localhost:8086/users/1
    PUT -> http://localhost:8086/users/:id
    DELETE -> http://localhost:8086/users/:id

    BasicAuth Var
    username:test
    pwd:test
    olarak auth olunması gereklidir.

Servisin 6 tane methodu var Bunlar sırasıyla ekle tüm userları sorgulama, soyada göre userları sorgulama, id ile user getirme
User Ekleme
    POST -> http://localhost:8086/users/add
Tüm Userları sorgulama
    GET -> http://localhost:8086/users/all
Soyada göre userları sorgulama
    GET -> http://localhost:8086/users/surname?surname=Kahraman
Id ile user getirme
    GET -> http://localhost:8086/users/:id
    GET -> http://localhost:8086/users/1
Id ve body ile name surname güncelleme
    PUT -> http://localhost:8086/users/:id
Id ile silme
    DELETE -> http://localhost:8086/users/:id

```