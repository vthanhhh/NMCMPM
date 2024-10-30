
function onLoginSuccess(username) {
    localStorage.setItem("username", username);
    document.getElementById("usernameDisplay").innerText = username;
}

window.onload = function() {
    const username = localStorage.getItem("username");
    if (username) {
        document.getElementById("usernameDisplay").innerText = username;
    }
}

function logout() {
    localStorage.removeItem("username");
    window.location.href = "trangchu-logout.html";
}
function addRoom() {
    const tenPhongTro = document.getElementById("tenPhongTro").value;
    const loaiNhaTro = document.getElementById("loaiNhaTro").value;
    const quanHuyen = document.getElementById("quanHuyen").value;
    const phuongXa = document.getElementById("phuongXa").value;
    const giaPhong = document.getElementById("giaPhong").value;
    const dienTich = document.getElementById("dienTich").value;
    const diaChi = document.getElementById("diaChi").value;
    const sdt = document.getElementById("sdt").value;

    const tienNghi = [];
    if (document.getElementById("camera").checked) tienNghi.push("Camera");
    if (document.getElementById("wifi").checked) tienNghi.push("Wifi");
    if (document.getElementById("gacLung").checked) tienNghi.push("Gác lửng");
    if (document.getElementById("tuBep").checked) tienNghi.push("Tủ bếp");
    if (document.getElementById("remCua").checked) tienNghi.push("Rèm cửa");
    if (document.getElementById("tivi").checked) tienNghi.push("Tivi");
    if (document.getElementById("giuong").checked) tienNghi.push("Giường");
    if (document.getElementById("tuLanh").checked) tienNghi.push("Tủ lạnh");

    const moTa = document.getElementById("moTa").value;
    const anhDaiDien = document.getElementById("anhDaiDien").files[0];
    const anhPhongTro = document.getElementById("anhPhongTro").files;

    const room = {
        tenPhongTro,
        loaiNhaTro,
        quanHuyen,
        phuongXa,
        giaPhong,
        dienTich,
        diaChi,
        sdt,
        tienNghi,
        moTa,
        anhDaiDien: anhDaiDien ? anhDaiDien.name : null,
        anhPhongTro: Array.from(anhPhongTro).map(file => file.name)
    };

    let roomList = JSON.parse(localStorage.getItem("roomList")) || [];
    roomList.push(room);

    localStorage.setItem("roomList", JSON.stringify(roomList));

    alert("Phòng trọ đã được thêm thành công!");

    displayRooms();
}
