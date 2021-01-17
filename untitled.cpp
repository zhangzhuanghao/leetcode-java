#include <iostream>
#include <thread>
#include <atomic>

using namespace std;

atomic<int> state{ 0 };

void f1() {
    for (int i = 0; i < 10; ++i) {
        while (1) {
            int expected{ 0 };
            if (state.compare_exchange_weak(expected, 1)) break;
            this_thread::sleep_for(chrono::milliseconds(1));
        }
        cout << i + 1 << " ";
        state = 2;
    }
}

void f2() {
    for (int i = 0; i < 10; ++i) {
        while (1) {
            int expected{ 2 };
            if (state.compare_exchange_weak(expected, 3)) break;
            this_thread::sleep_for(chrono::milliseconds(1));
        }
        cout << char(i + 'a') << " ";
        state = 0;
    }
}

int main()
{
    thread t1(f1), t2(f2);
    t1.join();
    t2.join();
    return 0;
}
