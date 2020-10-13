import socket

def getIP(host):
    ipAddress = socket.gethostbyname(host)
    return ipAddress

def getNameByCSV(filename):
    hosts = []
    
    for line in open(filename):
        for host in line.split(";"):
            hosts.append(host)

    return hosts


if __name__ == "__main__": 
    hosts =  getNameByCSV("check.txt")

    for hostName in hosts:
        print(f"IP address dell'host {hostName} è: {getIP(hostName)}")