namespace java demo.thrift
service CalcService {
    string sayHello(),
    i32 add(1:i32 a, 2:i32 b),
    i32 divide(1:i32 a, 2:i32 b),
}