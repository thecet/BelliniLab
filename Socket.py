import socket

def getIP(host):
    ipAddress = socket.gethostbyname(hostName)
    return ipAddress


if __name__ == "__main__": 
    hostName  = "www.marconivr.it"
    ipAddress = socket.gethostbyname(hostName)
    print(f"IP address dell'host {hostName} è: {getIP(hostName)}")