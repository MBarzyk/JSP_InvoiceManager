Napisz aplikację, która pozwala dodawać i zarządzać rachunkami(invoice) w firmie. Rachunek (lub faktura) będzie posiadała listę produktów. Faktura jest wystawiona do konkretnego klienta. Wystarczy, że faktura zawiera dane tego klienta (jako pola). Faktura powinna posiadać pola zgodne z treścią ze wcześniejszych zajęć:

public class Invoice { private Long id; private LocalDateTime dateOfCreation private String clientName private boolean ifPaid; private LocalDateTime dateOfRelease; private LocalDateTime dateOfPayment; @Formula(value = "(SELECT SUM(p.price * p.stock) from product p where p.invoice_id = id )") private Double billValue; @OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER) private List product; } oraz pola dodatkowe:

Nip klienta (który musi być 10 znakowy)
adres klienta oraz produkt o budowie:
public class Product{ private Long id; private String name; private double price; @Formula(value = "(price*0.23)") private double tax; @Enumerated(value = EnumType.STRING) private TaxType tax; private int stock; private Invoice invoice; } Aplikacja powinna dostarczać funkcji:

dodawanie faktur,
dodawanie produktów do faktur
oznaczanie faktur jako wydanych (zamknięta/wydana faktura, to faktura do której nie można dodawać już więcej produktów 
[zablokuj dostep do dodawania]).
oznaczanie faktur jako opłaconych (opłacona faktura może być tylko raz, więc guzik "oznacz jako opłacona" jest tam dopóki faktura 
nie została opłacona)
w tabeli faktur wyświetl wszystkie pola faktury wraz z informacją o kliencie, o wysokości rachunku, oraz o datach opłacenia i dodaj również w tabeli liczbę produktów która znajduje się na powiązanej liście.
dodawanie produktów do faktur:
produkty powinny być powiązane z fakturami,
możliwe jest dodanie produktów dopóki faktura nie jest 'zamknięta' czyli nie jest ustawione 'dateOfRelease'
faktury mają 'TaxType tax' który określa jak duży jest podatek (https://stackoverflow.com/questions/17845697/hibernate-formula-case-statement)
TaxType tax - podatek o wartości 0.23 (PRODUCTS) lub 0.08 (SERVICES). (rozwiązanie poniżej, zapytanie SQL)
na liście produktów powinna wyświetlać się pełna lista produktów oraz możliwość ich edycji (dopóki faktura nie jest zamknięta)
produkty na liście można usunąć/dodać (dopóki faktura nie jest zamknięta)
przyciski edit i delete na liście produktów znikają po tym jak faktura jest wydana/opłacona.