# Chat Application (Spring Boot & WebSocket)

Bu proje, kullanıcılar arasında anlık mesajlaşmayı sağlamak amacıyla Spring Boot ve WebSocket teknolojileri kullanarak geliştirilmiş bir chat uygulamasıdır. Uygulama, kullanıcıların sohbet odalarına katılmasına ve birbirlerine mesaj göndermesine olanak tanır.

## Teknolojiler

- **Spring Boot**: Java tabanlı bir framework olan Spring Boot, hızlı geliştirme ve konfigürasyon ile uygulamanın backend kısmını yönetir.
- **WebSocket**: Anlık, çift yönlü iletişim sağlayan WebSocket protokolü kullanılarak, kullanıcılar arasında gerçek zamanlı mesajlaşma sağlanır.
- **JavaScript**: WebSocket bağlantısının yönetimi ve kullanıcı arayüzünün interaktif hale getirilmesi için JavaScript kullanılmıştır.
- **HTML/CSS**: Kullanıcı arayüzü için temel HTML ve CSS kullanılmıştır.

## Özellikler

- **Gerçek zamanlı mesajlaşma**: Kullanıcılar birbirlerine anlık mesaj gönderebilir.
- **Kullanıcı yönetimi**: Kullanıcılar bir takma ad (nickname) ve gerçek ad (real name) ile sisteme giriş yapar.
- **Aktif kullanıcılar listesi**: Sistemde aktif olan kullanıcılar, kullanıcı arayüzünde gösterilir.
- **Mesajlaşma geçmişi**: Kullanıcılar, seçtikleri kişiyle geçmiş mesajlarını görüntüleyebilir.

## Proje Kurulumu

### Gerekli Bağımlılıklar

- **Java 11 veya daha yeni bir sürüm**
- **Maven**: Bağımlılık yönetimi için Maven kullanılmaktadır.

### Projeyi Çalıştırma

1. **Proje dosyalarını indirin**:
    ```bash
    git clone https://github.com/eyupkerem/webSocket.git
    ```

2. **Bağımlılıkları yükleyin**:
   Maven kullanarak proje bağımlılıklarını yükleyin:
    ```bash
    mvn clean install
    ```

3. **Spring Boot Uygulamasını Başlatın**:
   Projeyi başlatmak için aşağıdaki komutu kullanabilirsiniz:
    ```bash
    mvn spring-boot:run
    ```

   Uygulama, varsayılan olarak `http://localhost:8090` adresinde çalışacaktır.

### Frontend Arayüzü

Uygulama arayüzü, basit bir chat odası içerir. Kullanıcılar, nickname ve gerçek isimle giriş yaptıktan sonra aktif kullanıcılar listesine katılabilir. Kullanıcılar birbirlerine mesaj gönderebilirler ve mesajlaşmalar gerçek zamanlı olarak güncellenir.

### Kullanıcı Girişi

- **Nickname**: Sistem üzerinde benzersiz olmalı ve her kullanıcı için farklı bir takma ad gereklidir.
- **Real Name**: Gerçek isim, sohbetlerde görünür.

### Mesaj Gönderimi

- Kullanıcılar, bir kullanıcıyı seçtikten sonra sağ alttaki metin kutusuna mesajlarını yazarak gönderebilirler.

### Logout

Kullanıcı, sohbet odasından çıkmak için **Logout** butonunu kullanabilir.
