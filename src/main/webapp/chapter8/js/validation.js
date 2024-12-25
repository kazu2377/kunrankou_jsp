// ボタンクリック時の処理を追加
const submitButton = document.getElementById("submitButton");

submitButton.addEventListener("click", function (event) {
    // 入力フィールドの値を取得
    const userInput = document.getElementById("userInput").value;

    // 入力が空白または未入力の場合はエラーメッセージを表示して送信をキャンセル
    if (userInput.trim() === "") {
        alert("お名前を入力してください。");
        event.preventDefault(); // フォーム送信をキャンセル
    }
});
