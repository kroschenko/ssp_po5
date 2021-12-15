using System;

namespace lab6._1._5
{
    abstract class OS
    {
        public abstract void OperationSystem();
    }

    abstract class Camera
    {
        public abstract void InstallCamera();
    }

    abstract class CPU
    {
        public abstract void InstallCPU();
    }

    class Android : OS
    {
        public override void OperationSystem()
        {
            Console.WriteLine("Установлена Android");
        }
    }

    class IOS : OS
    {
        public override void OperationSystem()
        {
            Console.WriteLine("Установлена IOS");
        }
    }

    class Front : Camera
    {
        public override void InstallCamera()
        {
            Console.WriteLine("Установлена фронтальная камера");
        }
    }

    class Main : Camera
    {
        public override void InstallCamera()
        {
            Console.WriteLine("Установлена основная камера");
        }
    }

    class M1 : CPU
    {
        public override void InstallCPU()
        {
            Console.WriteLine("Установлена процессор М1");
        }
    }

    class Mi_MIX : CPU
    {
        public override void InstallCPU()
        {
            Console.WriteLine("Установлена процессор Mi_MIX");
        }
    }

    abstract class PhoneFactory
    {
        public abstract Camera installCamera();
        public abstract OS createOS();
        public abstract CPU installCPU();
    }
    
    class AndroidFactory : PhoneFactory
    {
        public override Camera installCamera()
        {
            return new Front();
        }

        public override OS createOS()
        {
            return new Android();
        }
        public override CPU installCPU()
        {
            return new Mi_MIX();
        }
    }
    
    class IOSFactory : PhoneFactory
    {
        public override Camera installCamera()
        {
            return new Main();
        }
        public override OS createOS()
        {
            return new IOS();
        }
        public override CPU installCPU()
        {
            return new M1();
        }
    }
    
    class Phone
    {
        private OS operationSystem;
        private Camera install_Camera;
        private CPU install_CPU;
        public Phone(PhoneFactory factory)
        {
            operationSystem = factory.createOS();
            install_Camera = factory.installCamera();
            install_CPU = factory.installCPU();
        }
        public void installCamera()
        {
            install_Camera.InstallCamera();
        }
        public void OperationSystem()
        {
            operationSystem.OperationSystem();
        }
        public void installCPU()
        {
            install_CPU.InstallCPU();
        }
    }
}