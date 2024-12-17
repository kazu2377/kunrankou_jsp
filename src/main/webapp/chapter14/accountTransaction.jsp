<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>口座取引</title>
</head>
<body>
    <h1>口座取引</h1>
    <form action="accountTransaction" method="post">
        <label for="accountId">口座ID:</label>
        <input type="number" id="accountId" name="accountId" required><br><br>
        
        <label for="action">アクション:</label>
        <select id="action" name="action" required>
            <option value="deposit">デポジット（入金）</option>
            <option value="withdraw">引き出し（出金）</option>
        </select><br><br>
        
        <label for="amount">金額:</label>
        <input type="number" step="0.01" id="amount" name="amount" required><br><br>
        
        <button type="submit">送信</button>
    </form>
</body>
</html>