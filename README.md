# **Appium test Android aplikacije**

## Instalacija Android Studio razvojnog alata

> 1. Kliknite na <https://developer.android.com/studio>.
> 2. Skinite Android Studio.
> 3. Instalirajte Android Studio u svoj sustav.

Ukoliko imate problema s instalacijom Android Studio razvojnog alata pratite upute na <https://developer.android.com/studio/install>.

## Postavljanje varijable okruženja

> 1. Idite na Upravljačku ploču>Sustav i sigurnost>Sustav.
> 2. Na lijevoj ploči kliknite na "Dodatne postavke sustava".
> 3. Iz skočnog prozora "Svojstva sustava" kliknite karticu "Dodatno", a zatim kliknite gumb "Varijable okruženja".
> 4. Iz skočnog prozora "Varijable okruženja" kliknite gumb "Novo".
> 5. Za naziv korisničke varijable unesite ANDROID_HOME.
> 6. Za vrijednost korisničke varijable unesite putanju do Vaše Android SDK mape.
> 7. Kliknite na gumb "U redu".

## Kreiranje emulatora (virtualnog uređaja) unutar Android Studio razvojnog alata

> Pratite upute na <https://developer.android.com/studio/run/managing-avds> ako nemate instaliran emulator.

## Provjera uspješnog kreiranja emulatora

> 1. Otvorite "Naredbeni redak".
> 2. Prebacite se na putanju do "platform-tools" pomoću naredbe 'cd'. Primjer naredbe: cd C:\Users\Student\AppData\Local\Android\Sdk\platform-tools.
> 3. Pritisnite enter.
> 4. Pokrenite 'adb devices' naredbu. Trebao bi se prikazati id emulatora ako postoji. 
> 5. Ako emulator ne postoji, odnosno ako se id emulatora nije ispisao, onda je potrebno kreirati emulator.

## Pokretanje emulatora 

> * Pokretanje emulatora iz Android Studia
> 	1. Idite na Tools>AVD Manager>Run ako je emulator kreiran.
> 	2. Ako emulator nije kreiran onda je potrebno kreirati emulator.
> * Pokretanje emulatora iz naredbenog redka
> 	1. Otvorite "Naredbeni redak".
> 	2. Prebacite se na putanju do "emulator" pomoću naredbe 'cd'. Primjer naredbe: cd C:\Users\Korisnik\AppData\Local\Android\Sdk\emulator.
> 	3. Pokrenite 'emulator -avd -list-avds' naredbu kako bi ste dobili ispis postojećih emulatora.
> 	4. Pokrenite 'emulator -avd naziv_pametnog_uređaja' naredbu kako bi ste pokrenuli emulator. Primjer naredbe: emulator -avd Nexus_5X_API_28.
> 	5. Ukoliko dođe do pogreške pokrenite emulator direktno iz Android Studia.
> * Korištenje pravog uređaja umjesto emulatora
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


