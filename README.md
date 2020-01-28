# Appium test Android aplikacije

Appium je slobodno distribuirani okvir za testiranje korisničkog sučelja otvorenog koda za
mobilne aplikacije. Appium omogućuje provjeru autentičnih, hibridnih i web aplikacija i podržava test
automatizacije na fizičkim uređajima, kao i emulator ili simulator. Pojedinačni API radi za testne skripte
za Android i iOS platforme.

Nema ovisnosti o operacijskom sustavu mobilnog uređaja. Budući da APPIUM ima okvir ili omot koji
prevodi naredbe Selenium Webdriver u komande UIAutomation (iOS) ili UIAutomator (Android) ovisno o
vrsti uređaja, ne ovisi o vrsti operacijskog sustava.

Appium podržava sve jezike koji imaju klijentske biblioteke Selenium kao što su Java, Objective C,
JavaScript s node.js, PHP, Ruby, Python, C # itd.

---

**Praćenjem navedenih koraka možete pratiti postupak testiranja Android aplikacije pomoću Appium testa.**

---

## 1. Instalacija Android Studio razvojnog alata

> 1. Kliknite na <https://developer.android.com/studio>.
> 2. Skinite Android Studio.
> 3. Instalirajte Android Studio u svoj sustav.

Ukoliko imate problema s instalacijom Android Studio razvojnog alata pratite upute na <https://developer.android.com/studio/install>.

## 2. Postavljanje varijable okruženja

> 1. Idite na Upravljačku ploču>Sustav i sigurnost>Sustav.
> 2. Na lijevoj ploči kliknite na "Dodatne postavke sustava".
> 3. Iz skočnog prozora "Svojstva sustava" kliknite karticu "Dodatno", a zatim kliknite gumb "Varijable okruženja".
> 4. Iz skočnog prozora "Varijable okruženja" kliknite gumb "Novo".
> 5. Za naziv korisničke varijable unesite ANDROID_HOME.
> 6. Za vrijednost korisničke varijable unesite putanju do Vaše Android SDK mape.
> 7. Kliknite na gumb "U redu".

## 3. Kreiranje emulatora (virtualnog uređaja) unutar Android Studio razvojnog alata

> Pratite upute na <https://developer.android.com/studio/run/managing-avds> ako nemate instaliran emulator.

## 4. Provjera uspješnog kreiranja emulatora

> 1. Otvorite "Naredbeni redak".
> 2. Prebacite se na putanju do "platform-tools" pomoću naredbe 'cd'. Primjer naredbe: cd C:\Users\Student\AppData\Local\Android\Sdk\platform-tools.
> 3. Pritisnite enter.
> 4. Pokrenite 'adb devices' naredbu. Trebao bi se prikazati id emulatora ako postoji. 
> 5. Ako emulator ne postoji, odnosno ako se id emulatora nije ispisao, onda je potrebno kreirati emulator.

## 5. Pokretanje emulatora 

> * Pokretanje emulatora iz Android Studia
> 	1. Idite na Tools>AVD Manager>Run ako je emulator kreiran.
> 	2. Ako emulator nije kreiran onda je potrebno kreirati emulator.
>
> * Pokretanje emulatora iz naredbenog retka
> 	1. Otvorite "Naredbeni redak".
> 	2. Prebacite se na putanju do "emulator" pomoću naredbe 'cd'. Primjer naredbe: cd C:\Users\Korisnik\AppData\Local\Android\Sdk\emulator.
> 	3. Pokrenite 'emulator -avd -list-avds' naredbu kako bi ste dobili ispis postojećih emulatora.
> 	4. Pokrenite 'emulator -avd naziv_pametnog_uređaja' naredbu kako bi ste pokrenuli emulator. Primjer naredbe: emulator -avd Nexus_5X_API_28.
> 	5. Ukoliko dođe do pogreške pokrenite emulator direktno iz Android Studia.
>
> * Korištenje pravog uređaja
> 	1. Otvorite "Postavke" uređaja na Android telefonu.
>	2. Dođite na dno izbornika i kliknite "Sustav".
> 	3. Na sljedećem zaslonu kliknite "O telefonu".
>	4. Ponovno se pomaknite do dna kako bi ste pronašli odjeljak "Broj međuverzije".
>	5. Klikčite 5-10 puta za redom na "Broj međuverzije" kako bi ste omogućili opcije razvoja na uređaju.
>	6. Ako imate sigurnosni PIN/zaporku, od vas će se tražiti da ga unesete
>	7. Nakon toga bi trebalo omogućiti opcije za razvojne programere i vidjet ćete obavijest "Sada ste developer".
>	8. Nakon što je omogućeno, idite na Postavke>Sustav>Napredno. Sada kada ste uspješno omogućili novi skup opcija, nastavite do sljedećeg odjeljka kako biste odmah omogućili USB ispravljanje pogrešaka na uređaju.
> 	9. Pokrenite aplikaciju na pravom uređaju pomoću Android Studia.

Odaberite sami jednu od tri ponuđene opcije za pokretanje emulatora.

## 6. Pokretanje testne aplikacije na emulatoru

> 1. Otvorite "Naredbeni redak".
> 2. Prebacite se na putanju do "platform-tools" pomoću naredbe 'cd'. Primjer naredbe: cd C:\Users\Student\AppData\Local\Android\Sdk\platform-tools.
> 3. Pritisnite enter.
> 4. Pokrenite 'adb -s id_emulatora install putanja_do_apk' naredbu kako bi instalirali aplikaciju, na emulator, koju želite testirati. Primjer naredbe: adb -s emulator-5554 install C:\Users\Korisnik\Documents\Apk\apk-debug.apk
> 5. Pokrenite 'adb start-server' naredbu koja će pokrenut ADB poslužitelj koji će Appium upotrebljavati za slanje naredbi na vaš Android uređaj.

## 7. Instalacija, postavljanje i pokretanje Appium alata za testiranje

Appium je "HTTP poslužitelj" napisan koristeći Node.js platformu i pogoni iOS i Android sesiju
pomoću Webdriver JSON mrežnog protokola. Stoga, prije nego što se Appium poslužitelj instalira i
pokrene, potrebno je instalirati Node.js platformu.

Provjerite da li je Node.js platforma instalirana na vaš sustav tako da pokrenete naredbu 'node -v' u naredbenom retku.
Ako nije, preuzmite Node.js instalaciju na sljedećoj poveznici: <https://nodejs.org/en/download/>

Ako je Node.js platforma instalirana (node -v naredba ispisuje verziju na ekranu), možete započeti
instalaciju Appium poslužitelja:

> 1. Idite na <http://appium.io/> i kliknite "Preuzmi Appium".
> 2. Za Windows sustave odaberite *.exe datoteku i preuzmite ju.
> 3. Pokrenite Appium Desktop.
> 4. Podesite konfiguraciju za ANDROID_HOME i JAVA_HOME varijable. Za ANDROID_HOME unesite putanju do "sdk" mape, a za JAVA_HOME unesite putanju do "bin" mape.
> 5. Vidjet ćete prozor poslužitelja sa Pokreni tipkom. On popunjava zadanu "host" i "port" opciju koju možete promijeniti (ostavite predefinirane postavke).
> 6. Kada kliknete gumb Pokreni poslužitelj, novi poslužitelj pokreće se na zadanoj host adresi i portu. Prikazuje se izlazni dnevnik (eng. log) poslužitelja.
> 7. Možete unijeti željene sposobnosti mobilnog uređaja i započeti sesiju. 
>  Primjer:
>  {
>  "app": "D:\\Student\\MTTPP\app-debug.apk",
>  "VERSION": "9.0",
>  "deviceName": "emulator",
>  "platformName": "Android"
>  }
> 8. Sada ste spremni pregledavati svojstva elemenata zadane aplikacije na vašem mobilnom uređaju ili emulatoru.

## 8. Instalacija, postavljanje i pokretanje Intellij razvojnog alata

> 1. Preuzmite IntelliJ razvojni alat. Idite na <https://www.jetbrains.com/idea/download/> i skinite ga.
> 2. Instalirajte Intellij. 
> 3. Nakon uspješne instalacije pokrenite Intellij te stvorite novi Maven projekt odabirom File>New>Project>Maven. 
> 4. Ubacite Appium i TestNG biblioteke u novi projekt (pom.xml) uz odabir enable auto-import opcije. 
> 5. Ukoliko želite automatski stvoriti izvješća o izvršenim testovima koristite i maven-surefire-plugin.
> 5. Kreirajte novu testnu klasu za testiranje Android aplikacije gdje će biti izvršeni testovi. 
> 6. Za testiranje aplikacije koja je korištena u ovom primjeru potreban kod možete pronaći u <>. 
> 7. Pokrenite test desnim klikom na naziv klase te odaberite opciju "Run" za pokretanje testa. 
> 8. Nakon toga otvara se emulator gdje se izvršavaju testovi koji su napisani i prikazuju se. 
> 9. Nakon završetka testa ispisuje se koliko je testova prošlo ili palo.


