import sys

def compare_files(req_num):
    file1_path = f'expected_output/Req{req_num}.txt'
    file2_path = f'output/Req{req_num}.txt'

    try:
        with open(file1_path, 'r', encoding='utf-8') as f1, open(file2_path, 'r', encoding='utf-8') as f2:
            lines1 = f1.readlines()
            lines2 = f2.readlines()

        # Kiểm tra sự giống nhau
        if lines1 == lines2:
            print(f"Req{req_num}: 2 file hoàn toàn giống nhau")
        else:
            # Tìm sự khác nhau
            for line_num, (line1, line2) in enumerate(zip(lines1, lines2), start=1):
                if line1 != line2:
                    print(f"Req{req_num}: Sự khác nhau ở dòng {line_num}:")
                    print(f"File 1: {line1.strip()}")
                    print(f"File 2: {line2.strip()}")
                    print("\n")
    except FileNotFoundError:
        print(f"Không tìm thấy file cho Req{req_num}")

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Sử dụng: python check.py <Req_number>")
        sys.exit(1)

    req_number = int(sys.argv[1])

    if 1 <= req_number <= 7:
        compare_files(req_number)
    else:
        print("Vui lòng nhập số Req từ 1 đến 7.")
