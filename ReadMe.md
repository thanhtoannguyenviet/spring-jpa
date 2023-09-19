# Spring JPA:
N
## REQUIRES_NEW: 
Tạo một giao dịch mới độc lập vs giao dịch hiện tại. Nếu có giao dịch đang diễn ra, tạm dừng và thực thi giao dịch này. Nếu giao dịch cha hoặc giao dịch mới gặp lỗi và rollback, cả hai sẻ rollback riêng biệt.
## MANDATORY
Tạo ra một transaction mới phụ thuộc vào 1 transaction bên ngoài. Khi nó là 1 transaction duy nhất được gọi thì sẻ bị lỗi IllegalTransactionStateException.
## NESTED:
Tạo một giao dịch lồng bên trong giao dịch hiện tại. Nếu không có giao dịch nào đang tồn tại th tạo giao dịch mới. Là một phần của giao dịch cha, khi cha commit hoặc rollback, thì giao dịch này cũng sẽ commit hoặc rollback riêng biệt. Còn nếu giao dịch lồng rollback thì chỉ giao dịch lồng rollback thôi, không ảnh hưởng đến giao dịch cha
## SUPPORTS:
Tạo một giao dịch mới độc lập vs giao dịch hiện tại. Nếu giao dịch ngoài rollback thì giao dịch này cũng rollback theo.
## NOT SUPPORT