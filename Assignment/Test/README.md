```mermaid
graph TD
    A[Bắt đầu: Gọi add(account)] --> B{account == null?};
    B -- Có --> F[Thất bại: return false];
    B -- Không --> C{count >= accList.length?};
    C -- Có --> F;
    C -- Không --> D[Thành công: accList[count] = account];
    D --> E[Cập nhật: count++];
    E --> G[Kết thúc: return true];
```
