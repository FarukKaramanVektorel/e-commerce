# E-Commerce Application

Bu proje, Hibernate ile PostgreSQL veritabanı kullanarak basit bir e-ticaret uygulaması geliştirmek amacıyla oluşturulmuştur. Proje, müşteri, ürün, kategori ve müşteri bilgileri gibi temel işlevleri yönetmek için konsol tabanlı bir uygulamadır.

## Kullanılan Teknolojiler
- **Java**: Projenin ana programlama dili.
- **Hibernate**: ORM (Object Relational Mapping) için kullanıldı.
- **PostgreSQL**: Veritabanı yönetim sistemi.
- **Lombok**: Java sınıflarında gereksiz kod yazımını azaltmak için kullanıldı.
- **Maven**: Proje yönetimi ve bağımlılık yönetimi için kullanıldı.

## Proje Yapısı

### Model (Entity) Sınıfları
- **Customer**: Müşteri bilgilerini (kullanıcı adı ve şifre) içerir.
- **Product**: Ürün bilgilerini (isim, kategori, fiyat ve stok adedi) içerir.
- **Category**: Ürün kategorisi bilgilerini içerir.
- **CustomerInfo**: Müşteri adresi ve diğer bilgilerini içerir.
- **CustomerPrice**: Müşteri ve ürün id'leri, işlem tarihi ve ürün adedini içerir.

### Repository Sınıfları
Her bir model sınıfı için CRUD işlemlerini gerçekleştiren sınıflar:
- **CustomerRepository**
- **ProductRepository**
- **CategoryRepository**
- **CustomerInfoRepository**
- **CustomerPriceRepository**

### Service Sınıfları
Repository sınıflarını kullanarak iş mantığını gerçekleştiren sınıflar:
- **CustomerService**
- **ProductService**
- **CategoryService**
- **CustomerInfoService**
- **CustomerPriceService**

### Controller Sınıfları
Konsol üzerinden kullanıcı girdilerini alarak servis sınıfları aracılığıyla işlemleri gerçekleştiren sınıflar:
- **CustomerController**
- **ProductController**
- **CategoryController**
- **CustomerInfoController**
- **CustomerPriceController**

### MainController
Kullanıcının yapacağı işlemleri seçip ilgili controller sınıflarına yönlendiren ana sınıf.

### Hibernate Konfigürasyonu
Hibernate konfigürasyonu `util.HibernateConfig` sınıfında tanımlanmıştır. Bu sınıf, Hibernate'in yapılandırma dosyasını yükleyerek `SessionFactory` nesnesi oluşturur.

## Kurulum ve Çalıştırma

### Bağımlılıkları Yükleyin
Maven kullanarak gerekli bağımlılıkları yükleyin.
```sh
mvn clean install
```
### Veritabanı Yapılandırması
utils paketi altında bulunan HibernateConfig.java dosyasına PostgreSQL veritabanı bağlantı bilgilerinizi girin.
### Veritabanı Yapılandırması
utils paketi altında bulunan HibernateConfig.java dosyasında gerekli düzeltmeleri yapınız

```java
            Properties prop=new Properties();
    		prop.put("hibernate.connection.driver_class", "org.postgresql.Driver");
    		prop.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/commerce");
    		prop.put("hibernate.connection.username", "postgres");
    		prop.put("hibernate.connection.password", "1234");
    		prop.put("hibernate.show_sql", "true");		
    		prop.put("hibernate.hbm2ddl.auto", "update");  		
```
### Veritabanını Oluşturun
PostgreSQL'de commerce isimli bir veritabanı oluşturun.

### Uygulamayı Çalıştırın
MainApp sınıfını çalıştırın.
```sh
mvn exec:java -Dexec.mainClass="application.MainApp"
```
## Kullanım
Uygulama, kullanıcıdan konsol üzerinden girdiler alarak işlemleri gerçekleştirir. Kullanıcı, müşteri, ürün, kategori ve müşteri bilgileri ile ilgili CRUD (Create, Read, Update, Delete) işlemlerini yapabilir.

Uygulama başlatıldığında bir menü görüntülenir.
Kullanıcı, yapmak istediği işlemi seçer.
İlgili controller sınıfı, kullanıcı girdilerini alarak işlemleri gerçekleştirir.
### Katkıda Bulunma
Katkıda bulunmak isterseniz, lütfen bir pull request gönderin ya da bir sorun bildirin.

## Lisans
Bu proje MIT Lisansı ile lisanslanmıştır. Daha fazla bilgi için LICENSE dosyasına bakın.
