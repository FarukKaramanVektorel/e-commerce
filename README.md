### E-Commerce Application
Bu proje, Hibernate ile PostgreSQL veritabanı kullanarak basit bir e-ticaret uygulaması geliştirmek amacıyla oluşturulmuştur. Proje, müşteri, ürün, kategori ve müşteri bilgileri gibi temel işlevleri yönetmek için konsol tabanlı bir uygulamadır.

Kullanılan Teknolojiler
Java: Projenin ana programlama dili.
Hibernate: ORM (Object Relational Mapping) için kullanıldı.
PostgreSQL: Veritabanı yönetim sistemi.
Lombok: Java sınıflarında gereksiz kod yazımını azaltmak için kullanıldı.
Maven: Proje yönetimi ve bağımlılık yönetimi için kullanıldı.
Proje Yapısı
Model (Entity) Sınıfları
Customer: Müşteri bilgilerini (kullanıcı adı ve şifre) içerir.
Product: Ürün bilgilerini (isim, kategori, fiyat ve stok adedi) içerir.
Category: Ürün kategorisi bilgilerini içerir.
CustomerInfo: Müşteri adresi ve diğer bilgilerini içerir.
CustomerPrice: Müşteri ve ürün id'leri, işlem tarihi ve ürün adedini içerir.
Repository Sınıfları
Her bir model sınıfı için CRUD işlemlerini gerçekleştiren sınıflar:

CustomerRepository
ProductRepository
CategoryRepository
CustomerInfoRepository
CustomerPriceRepository
Service Sınıfları
Repository sınıflarını kullanarak iş mantığını gerçekleştiren sınıflar:

CustomerService
ProductService
CategoryService
CustomerInfoService
CustomerPriceService
Controller Sınıfları
Konsol üzerinden kullanıcı girdilerini alarak servis sınıfları aracılığıyla işlemleri gerçekleştiren sınıflar:

CustomerController
ProductController
CategoryController
CustomerInfoController
CustomerPriceController
MainController
Kullanıcının yapacağı işlemleri seçip ilgili controller sınıflarına yönlendiren ana sınıf.

Hibernate Konfigürasyonu
Hibernate konfigürasyonu util.HibernateConfig sınıfında tanımlanmıştır. Bu sınıf, Hibernate'in yapılandırma dosyasını yükleyerek SessionFactory nesnesi oluşturur.

Kurulum ve Çalıştırma
Bağımlılıkları Yükleyin: Maven kullanarak gerekli bağımlılıkları yükleyin.

sh
Kodu kopyala
mvn clean install
Veritabanı Yapılandırması: src/main/resources dizininde hibernate.cfg.xml dosyasını oluşturun ve PostgreSQL veritabanı bağlantı bilgilerinizi girin.

xml
Kodu kopyala
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC "-//Hibernate/Hibernate Configuration DTD 3.0//EN" "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>
        <property name="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</property>
        <property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
        <property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/your_database</property>
        <property name="hibernate.connection.username">your_username</property>
        <property name="hibernate.connection.password">your_password</property>
        <property name="hibernate.hbm2ddl.auto">update</property>
        <property name="hibernate.show_sql">true</property>
    </session-factory>
</hibernate-configuration>
Veritabanını Oluşturun: PostgreSQL'de your_database isimli bir veritabanı oluşturun.

Uygulamayı Çalıştırın: MainApp sınıfını çalıştırın.

sh
Kodu kopyala
mvn exec:java -Dexec.mainClass="application.MainApp"
Kullanım
Uygulama, kullanıcıdan konsol üzerinden girdiler alarak işlemleri gerçekleştirir. Kullanıcı, müşteri, ürün, kategori ve müşteri bilgileri ile ilgili CRUD (Create, Read, Update, Delete) işlemlerini yapabilir.

Uygulama başlatıldığında bir menü görüntülenir.
Kullanıcı, yapmak istediği işlemi seçer.
İlgili controller sınıfı, kullanıcı girdilerini alarak işlemleri gerçekleştirir.
Katkıda Bulunma
Katkıda bulunmak isterseniz, lütfen bir pull request gönderin ya da bir sorun bildirin.

Lisans
Bu proje MIT Lisansı ile lisanslanmıştır. Daha fazla bilgi için LICENSE dosyasına bakın.
